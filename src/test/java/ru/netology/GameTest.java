package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test

    public void firstPlayerStronger() {  // Первый игрок сильнее
        Game game = new Game();

        Player rosaly = new Player(1, "rosaly", 85);
        Player robert = new Player(2, "robert", 15);

        game.register(rosaly);
        game.register(robert);

        int actual = game.round("rosaly", "robert");
        int expented = 1;

        Assertions.assertEquals(expented, actual);
    }

    @Test

    public void secondPlayerStronger() {  // Второй игрок сильнее
        Game game = new Game();

        Player rosaly = new Player(1, "rosaly", 38);
        Player robert = new Player(2, "robert", 80);

        game.register(rosaly);
        game.register(robert);

        int actual = game.round("rosaly", "robert");
        int expented = 2;

        Assertions.assertEquals(expented, actual);
    }

    @Test

    public void draw() {  // Ничья
        Game game = new Game();

        Player rosaly = new Player(1, "rosaly", 100);
        Player robert = new Player(2, "robert", 100);

        game.register(rosaly);
        game.register(robert);

        int actual = game.round("rosaly", "robert");
        int expented = 0;

        Assertions.assertEquals(expented, actual);
    }

    @Test

    public void FirstPlayerNotFound() {  // Не найден первый игрок
        Game game = new Game();

        Player rosaly = new Player(1, "rosaly", 67);
        Player robert = new Player(2, "robert", 15);


        game.register(rosaly);
        game.register(robert);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("sara", "robert")
        );
    }

    @Test
    public void secondPlayerNotFound() {  // Не найден второй Игрок
        Game game = new Game();

        Player rosaly = new Player(1, "rosaly", 114);
        Player robert = new Player(2, "robert", 122);


        game.register(rosaly);
        game.register(robert);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("rosaly", "klara")
        );
    }

    @Test
    public void noPlayersFound() {  // Не найдены игроки
        Game game = new Game();

        Player rosaly = new Player(1, "rosaly", 100);
        Player robert = new Player(2, "robert", 100);


        game.register(rosaly);
        game.register(robert);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("vlada", "misha")
        );
    }
}