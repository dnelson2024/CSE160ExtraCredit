package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Learning extends AppCompatActivity {
    //Boolean buttonPressed = false;

    String category = MainActivity.topic;
    // added 2
    String[] TravelInfo = {
            "Español: ¿Dónde puedo encontrar un taxi? \nEnglish: Where can I find a taxi?",
            "Español: ¿Cuánto cuesta? \nEnglish: How much is this?",
            "Español: ¿Dónde está este lugar? \nEnglish: Where is this place?",
            "Español: A la derecha \nEnglish: To the right",
            "Español: A la izquierda \nEnglish: To the left",
            "Español: Yo necesito una botella de agua. \nEnglish: I need a bottle of water.",
            "Español: ¿Cómo llego a...? \nEnglish: How do I get to...?",
            "Español: ¿Me puede ayudar? \nEnglish: Can you help me?",
            "Español: ¿Habla inglés? \nEnglish: Do you speak English?",
            "Español: ¿Qué hora es? \nEnglish: What time is it?",
            "Español: ¿Hay...? \nEnglish: Is there...?",
            "Español: Estoy perdido/a. \nEnglish: I am lost.",
            "Español: ¿Dónde está el hospital?. \nEnglish: Where is the hospital."
    };//13
    String[] IntroInfo = {
            "Español: Me llamo... \nEnglish: My name is...",
            "Español: Soy de... \nEnglish: I am from...",
            "Español: ¿Como estás? \nEnglish: How are you?",
            "Español: ¿Puedo ir al baño?\nEnglish: Can I use the bathroom?",
            "Español: Mucho gusto \nEnglish: Nice to meet you",
            "Español: Bien \nEnglish: Good",
            "Español: Hola \nEnglish: Hello",
            "Español: Buenos días \nEnglish: Good morning",
            "Español: Buenos tardes \n English: Good afternoon",
            "Español: Buenos noches \n English: Good night",
            "Español: ¿Cómo te llamas? \n English: What is your name?",
            "Español: Gracias \nEnglish: Thank you",
            "Español: Por favor \nEnglish: Please",
    }; //13

    String[] RestaurantInfo = {
            "Español: ¿Qué me recomienda? \nEnglish: What do you recommend?",
            "Español: ¿Tienen algún plato vegetariano?\nEnglish: Do you have a vegetarian option?",
            "Español: Con salsa \nEnglish: With sauce",
            "Español: Quiero pedir... \nEnglish: I would like to order...",
            "Español: Me gustaría más agua, por favor \nEnglish: I would like more water, please",
            "Español: ¿Tiene una reserva? \nEnglish: Do you have a reservation?",
            "Español: ¿Qué hay de especial hoy? \nEnglish: What is special today?",
            "Español: La cuenta, por favor \nEnglish: The bill, please",
            "Español: Tengo una reservación \nEnglish: I have a reservation",
            "Español: ¿Puedo ver el menú? \nEnglish: Can I look at the menu?",
            "Español: ¿Qué bebidas tiene? \nEnglish: What drinks do you have?",
            "Español: ¿Puedo sentarme en el bar? \nEnglish: Can you sit me at the bar?",
            "Español: La comida está deliciosa \nEnglish: The food is delicious"
    };
    String[] HobbiesNInterestsInfo = {
            "Español: ¿Tienes algún pasatiempo? \nEnglish: Do you have any hobbies?",
            "Español: Me gusta... \nEnglish: I like...",
            "Español: Escuchar música \nEnglish: To listen to music",
            "Español: Hacer deportes \nEnglish: To do sports",
            "Español: Ver la tele \nEnglish: To watch TV", "" +
            "Español: Cocinar \nEnglish: To bake",
            "Español: Bailar \nEnglish: To dance",
            "Español: Leer \nEnglish: To read",
            "Español: ¿Qué haces los fines de semana? \nEnglish: What do you do over the weekends?",
            "Español: Ir de compras \nEnglish: To go shopping",
            "Español: Jugar videojuegos \nEnglish: To play video games",
            "Español: Viajar \nEnglish: To travel",
            "Español: Ir a la playa \nEnglish: To go to the beach",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_learning);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView catTextView = findViewById(R.id.categorytextView);
        //travel
        if("Travel".equals(category)){
            catTextView.setText("Travel");
        }
        //introductory info
        else if("Introductions".equals(category)){
            catTextView.setText("Introductory Phrases");
        }
        //restuarant
        else if("Food".equals(category)){
            catTextView.setText("Restaurant");
        }
        //hobbies and interests
        else if("Hobbies".equals(category)){
            catTextView.setText("Hobbies and Interests");
        }
        else if ("null".equals(category)){
            catTextView.setText("Error");
        }
        else {
            catTextView.setText("Error");
        }
    }

    int i = 0;
    public void showInfo(View view) {
        //view.setEnabled(false);
        TextView textView = findViewById(R.id.informationTextView);
        ImageView imageView = findViewById(R.id.imageView);
        if (i < 12) {
            if ("Travel".equals(category)) {
                textView.setText(TravelInfo[i]);
                if (i == 0) {
                    imageView.setImageResource(R.drawable.taxi);
                } else if (i == 1) {
                    imageView.setImageResource(R.drawable.money);
                } else if (i == 2) {
                    imageView.setImageResource(R.drawable.house1);
                } else if (i == 3) {
                    imageView.setImageResource(R.drawable.right);
                } else if (i == 4) {
                    imageView.setImageResource(R.drawable.left);
                } else if (i == 5) {
                    imageView.setImageResource(R.drawable.waterbottle);
                } else {
                    imageView.setImageResource(R.drawable.books);
                }
            } else if ("Introductions".equals(category)) {
                textView.setText(IntroInfo[i]);

            } else if ("Food".equals(category)) {
                textView.setText(RestaurantInfo[i]);
            } else if ("Hobbies".equals(category)) {
                textView.setText(HobbiesNInterestsInfo[i]);
            }
        }
        i += 1;
        if (i == 12){
            i = 0;
        }
    }
        /*
        for (int i = 0; i < 4; i++){
            if("category1".equals(category)) {
                textView.setText(category1Info[i]);
            } else if ("category2".equals(category)) {
                textView.setText(category2Info[i]);
            } else if ("category3".equals(category)) {
                textView.setText(category3Info[i]);
            } else if ("category4".equals(category)) {
                textView.setText(category4Info[i]);
            }
        }*/

public void exit (View v){
    startActivity(new Intent(Learning.this, MainActivity.class));
}


}