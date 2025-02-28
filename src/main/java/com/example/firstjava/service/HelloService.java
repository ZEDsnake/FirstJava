package com.example.firstjava.service;

import com.example.firstjava.dto.UserMessageDto;
import com.example.firstjava.dto.UserMessageRequestDto;
import com.example.firstjava.entity.UserMessageEntity;
import com.example.firstjava.exception.MsgNotFoundException;
import com.example.firstjava.repository.HelloRepository;
import com.example.firstjava.repository.UserMessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class HelloService {

    private final HelloRepository helloRepository;
    private final UserMessageRepository userMessageRepository;
    private final Random random;

    public HelloService(HelloRepository helloRepository, UserMessageRepository userMessageRepository, Random random) {
        this.helloRepository = helloRepository;
        this.userMessageRepository = userMessageRepository;
        this.random = random;
    }

    public String sayHello() {
        String text = "Привет, засранец!";

        int storageCount = helloRepository.getStorageSize();
        String param = helloRepository.sayHello(random.nextInt(storageCount));

        return text + " " + param;
    }

    public String saveMsg(String text) {
        if (text == null || text.isBlank()) {
            return "Текст долден быть не пустой";
        }
        UserMessageEntity userMessageEntity = new UserMessageEntity();
        userMessageEntity.setMsg(text);

        userMessageRepository.save(userMessageEntity);
        return "Сообщение сохранено: " + text;
    }

    public UserMessageRequestDto saveMsg(UserMessageDto userMessageDto) {
        if (userMessageDto == null || userMessageDto.getMsg().isBlank()) {
            throw new RuntimeException("Текст долден быть не пустой");
        }

        String text = userMessageDto.getMsg();

        UserMessageEntity userMessageEntity = new UserMessageEntity();
        userMessageEntity.setMsg(text);

        userMessageRepository.save(userMessageEntity);

        UserMessageRequestDto response = new UserMessageRequestDto();
        response.setMsg("Сообщение сохранено: " + text);
        response.setLocalDateTime(LocalDateTime.now());

        return response;
    }

    public String getMsg(long id) {
        UserMessageEntity findEntity = userMessageRepository.getMsgFromId(id)
                .orElseThrow(() -> new MsgNotFoundException("Нет сообщения с id " + id));

        return "Сообщение с id " + id + " найдено: " + findEntity.getMsg();
    }
}
