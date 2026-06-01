package com.PedroLins.WorkshopMongo.Config;

import com.PedroLins.WorkshopMongo.Domain.post;
import com.PedroLins.WorkshopMongo.Domain.user;
import com.PedroLins.WorkshopMongo.Repositories.PostRepository;
import com.PedroLins.WorkshopMongo.Repositories.UserRepository;
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

        post post1 = new post(null, maria, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para SP. Abraços!");
        post post2 = new post(null, maria, sdf.parse("23/03/2018"), "Bom dia!!", "Acordei feliz hoje :D");


        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
