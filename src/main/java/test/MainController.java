package test;

import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MainController
    {
        public Image im1;
        public ImageView mainImage;

        /**
         * Каждая ячейка это 181 на 181 (но для ширины лучше использовать значение чуть меньше
         * от 177 до 181 это ~= 1.5 сантиметр
         * + еще надо брать во внимание что в видимая область будут видны края)
         *
         * image values ​​9x6 сантиметров или 1063х711 px
         *
         * Что бы переместь видимую область на другой объект нужну в переменной {@link #OFFSET_Y}
         * указать значение больше на 181 (это 0, 181, 362, 543)
         *
         * **/

        private static final int COLUMNS  =   5; // Количество колонок
        private static final int COUNT    =   7; // Количество в линию image
        private static final int OFFSET_X =   0; // Координата отсчета ддя кортинки(началоьная)
        private static final int OFFSET_Y =   0; // Координата отсчета ддя кортинки(конечная)
        private static final int WIDTH    =  177; // Ширина
        private static final int HEIGHT   = 181; // Высота

        @FXML public void initialize()
            {
                mainImage.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
                final Animation animation = new SpriteAnimation(mainImage, Duration.millis(5000), COUNT, COLUMNS, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);
                animation.setCycleCount(Animation.INDEFINITE);
                animation.play();
            }
    }