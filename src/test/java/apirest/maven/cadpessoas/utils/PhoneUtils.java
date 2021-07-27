package apirest.maven.cadpessoas.utils;

import apirest.maven.cadpessoas.dto.request.PhoneDTO;
import apirest.maven.cadpessoas.entity.Phone;
import apirest.maven.cadpessoas.enums.PhoneType;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "1999675-8601";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
