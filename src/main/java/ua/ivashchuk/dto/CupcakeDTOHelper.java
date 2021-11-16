package ua.ivashchuk.dto;

import org.springframework.web.multipart.MultipartFile;
import ua.ivashchuk.domains.Cupcake;

import java.io.IOException;
import java.util.Base64;

public class CupcakeDTOHelper {

    public static Cupcake createEntity(MultipartFile file, String name, String description, Double price) throws IOException{
        Cupcake cupcake = new Cupcake();
        cupcake.setName(name);
        cupcake.setDescription(description);
        cupcake.setPrice(price);
        cupcake.setEncodeImage(Base64.getEncoder().encodeToString(file.getBytes()));
        return cupcake;
    }
}
