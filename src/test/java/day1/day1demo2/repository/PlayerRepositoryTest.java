package day1.day1demo2.repository;

import day1.day1demo2.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Controller;

import javax.swing.plaf.SpinnerUI;

import static org.junit.jupiter.api.Assertions.*;

//DataJpaTest bruger H2 database
@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;
    Boolean isInitialized = false;

    @BeforeEach
    void setUp() {
        if (!isInitialized){
            playerRepository.save(new Player("Cristiano Ronaldo", "Portugal", "Forward"));
            playerRepository.save(new Player("Lionel Messi", "Argentina", "Forward"));
            playerRepository.save(new Player("Antoine Griezmann", "France", "Forward"));
            playerRepository.save(new Player("Mohamed Salah", "Egypt", "Forward"));
            playerRepository.save(new Player("Neymar", "Brazil", "Forward"));
            isInitialized = true;
        }
    }
    @Test
    public void deleteAll(){
        playerRepository.deleteAll();
        Long count = playerRepository.count();
        assertEquals(0,count);
    }

    @Test
    public void findbyName(){
        Player player = playerRepository.findByName("Cristiano Ronaldo");
        assertEquals("Cristiano Ronaldo",player.getName());
    }

    @Test
    public void findByNameLike(){
        Player player = playerRepository.findByNameLike("%Ronaldo%");
        assertEquals("Cristiano Ronaldo",player.getName());
    }

    @Test
    public void testAll(){
        Long count = playerRepository.count();
        assertEquals(5,count);
    }
}