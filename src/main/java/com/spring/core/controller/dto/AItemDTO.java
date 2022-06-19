package com.spring.core.controller.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
)
@Schema(
        title = "AItemDTO",
        description = "The base abstract Data Transfer Object."
)
public abstract class AItemDTO {

    @Schema(example = "123")
    private long id;

    @Schema(example = "unique-identifier-code")
    private String code;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AItemDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
