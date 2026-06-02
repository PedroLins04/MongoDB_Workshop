package com.PedroLins.WorkshopMongo.Config;

import com.PedroLins.WorkshopMongo.Domain.post;
import com.PedroLins.WorkshopMongo.Domain.user;
import com.PedroLins.WorkshopMongo.Repositories.PostRepository;
import com.PedroLins.WorkshopMongo.Repositories.UserRepository;
import com.PedroLins.WorkshopMongo.dto.authorDTO;
import com.PedroLins.WorkshopMongo.dto.commentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        user maria = new user(null, "Maria Brown", "maria@gmail.com");
        user alex = new user(null, "Alex Green", "alex@gmail.com");
        user bob = new user(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        post post1 = new post(null, new authorDTO(maria), sdf.parse("21/08/2025"), "Partiu viagem!", "Vou viajar para SP. Abraços!");
        post post2 = new post(null, new authorDTO(maria), sdf.parse("23/03/2026"), "Bom dia!!", "Acordei feliz hoje :D");
        post post3 = new post(null, new authorDTO(bob), sdf.parse("31/12/2025"), "Feliz ano novo a nóssss", "Que venham muitas graças!");
        post post4 = new post(null, new authorDTO(alex), sdf.parse("15/05/2026"), "Esse sol pede praia...", "Hoje tem surf!" );

        commentDTO comment1 = new commentDTO("Boa viagem", sdf.parse("21/08/2025"), new authorDTO(alex));
        commentDTO comment2 = new commentDTO("Aproveite!", sdf.parse("22/08/2025"), new authorDTO(bob));
        commentDTO comment3 = new commentDTO("Tenha um ótimo dia!!", sdf.parse("23/03/2018"), new authorDTO(alex));
        commentDTO comment4 = new commentDTO("Que esse ano seja de muitas vitórias :) ", sdf.parse("31/12/2025"), new authorDTO(maria));
        commentDTO comment5 = new commentDTO("Felicidades, feliz ano novo!!", sdf.parse("31/12/2025"), new authorDTO(alex));
        commentDTO comment6 = new commentDTO("Nos encontramos lá!!", sdf.parse("15/05/2026"), new authorDTO(bob));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().addAll(Arrays.asList(comment3));
        post3.getComments().addAll(Arrays.asList(comment4,comment5));
        post4.getComments().addAll(Arrays.asList(comment6));

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        bob.getPosts().add(post3);
        alex.getPosts().add(post4);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
