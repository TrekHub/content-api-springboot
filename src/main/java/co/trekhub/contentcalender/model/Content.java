package co.trekhub.contentcalender.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String desc,
        Status status,
        Type contentType,

        LocalDateTime createdAt,

        LocalDateTime updatedTime,

        String url
) {
}
