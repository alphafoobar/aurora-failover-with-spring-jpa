package example.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class UniqueIdService {
    private static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyz";

    public String createId(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(CHARS.charAt(ThreadLocalRandom.current().nextInt(0, CHARS.length())));
        }
        return sb.toString();
    }
}
