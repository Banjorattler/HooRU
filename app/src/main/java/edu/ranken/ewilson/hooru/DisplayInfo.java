package edu.ranken.ewilson.hooru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class DisplayInfo extends AppCompatActivity  {

    TextView textViewDisplayInfo;

    private String Name;
    private int Day;
    private int Month;
    private int Year;
    private String zodiac;
    private String zodiacDesc;
    private String chinese;
    private String chineseDesc;
    private String element;
    private int yearsOld;
    private int monthsOld;
    private int daysOld;
    private int dayOfYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);
        textViewDisplayInfo = findViewById(R.id.textViewDisplayInfo);

        Bundle bundle = getIntent().getExtras();
        String fullName = bundle.getString("Name");
        Name = fullName;
        int day = bundle.getInt("Day");
        Day = day;
        int month = bundle.getInt("Month");
        Month = month;
        int year = bundle.getInt("Year");
        Year = year;

        getZodiac();
        getChineseZodiac();
        dateDiff();
        daysOld();
        output();
    }

    public void getZodiac(){

        if(((Month == 11) && (Day >= 22)) || ((Month == 0) && (Day <= 19))){
            zodiac = "Capricorn";
            zodiacDesc = "The measured master planner of the horoscope family, Capricorn energy teaches us the power of structure and long-term goals.";
        }
        else if (((Month == 0) && (Day >= 20)) || ((Month == 1) && (Day <= 18))){
            zodiac = "Aquarius";
            zodiacDesc = "The mad scientist and humanitarian of the horoscope wheel, futuristic Aquarius energy helps us innovate and unite for social justice.";
        }
        else if (((Month == 1) && (Day >= 19)) || ((Month == 2) && (Day <= 20))){
            zodiac = "Pisces";
            zodiacDesc = "The dreamer and healer of the horoscope family, Pisces energy awakens compassion, imagination and artistry, uniting us as one.";
        }
        else if (((Month == 2) && (Day >= 21)) || ((Month == 3) && (Day <= 19))){
            zodiac = "Aries";
            zodiacDesc = "The pioneer and trailblazer of the horoscope wheel, Aries energy helps us initiate, fight for our beliefs and fearlessly put ourselves out there.";
        }
        else if (((Month == 3) && (Day >= 20)) || ((Month == 4) && (Day <= 20))){
            zodiac = "Taurus";
            zodiacDesc = "The persistent provider of the horoscope family, Taurus energy helps us seek security, enjoy earthly pleasures and get the job done.";
        }
        else if (((Month == 4) && (Day >= 21)) || ((Month == 5) && (Day <= 20))){
            zodiac = "Gemini";
            zodiacDesc = "The most versatile and vibrant horoscope sign, Gemini energy helps us communicate, collaborate and fly our freak flags at full mast.";
        }
        else if (((Month == 5) && (Day >= 21)) || ((Month == 6) && (Day <= 22))){
            zodiac = "Cancer";
            zodiacDesc = "The natural nurturer of the horoscope wheel, Cancer energy helps us connect with our feelings, plant deep roots and feather our family nests.";
        }
        else if (((Month == 6) && (Day >= 23)) || ((Month == 7) && (Day <= 22))){
            zodiac = "Leo";
            zodiacDesc = "The drama queen and regal ruler of the horoscope clan, Leo energy helps us shine, express ourselves boldly and wear our hearts on our sleeves.";
        }
        else if (((Month == 7) && (Day >= 23)) || ((Month == 8) && (Day <= 22))){
            zodiac = "Virgo";
            zodiacDesc = "The masterful helper of the horoscope wheel, Virgo energy teaches us to serve, do impeccable work and prioritize wellbeing—of ourselves, our loved ones and the planet.";
        }
        else if (((Month == 8) && (Day >= 23)) || ((Month == 9) && (Day <= 22))){
            zodiac = "Libra";
            zodiacDesc = "The balanced beautifier of the horoscope family, Libra energy inspires us to seek peace, harmony and cooperation—and to do it with style and grace.";
        }
        else if (((Month == 9) && (Day >= 23)) || ((Month == 10) && (Day <= 21))){
            zodiac = "Scorpio";
            zodiacDesc = "The most intense and focused of the horoscope signs, Scorpio energy helps us dive deep, merge our superpowers and form bonds that are built to last.";
        }
        else{
            zodiac = "Sagittarius";
            zodiacDesc = "The worldly adventurer of the horoscope wheel, Sagittarius energy inspires us to dream big, chase the impossible and take fearless risks.";
        }
    }

    public void getChineseZodiac(){

        switch(Year % 12) {
            case 4:
                chinese = "Rat";
                chineseDesc = "Quick-witted, resourceful, and versatile";
                break;

            case 5:
                chinese = "Ox";
                chineseDesc = "Decisive, honest, dependable, and hardworking";
                break;

            case 6:
                chinese = "Tiger";
                chineseDesc = "Brave, competitive, unpredictable, and self-confident";
                break;

            case 7:
                chinese = "Rabbit";
                chineseDesc = "Gentle, quiet, elegant, and alert; quick, skillful, kind, and patient";
                break;

            case 8:
                chinese = "Dragon";
                chineseDesc = "Confident, intelligent, ambitious, persevering, and hardworking";
                break;

            case 9:
                chinese = "Snake";
                chineseDesc = "Intelligent, courageous, confident, insightful, and communicative";
                break;

            case 10:
                chinese = "Horse";
                chineseDesc = "Animated, kind, straightforward, active, and energetic";
                break;

            case 11:
                chinese = "Goat";
                chineseDesc = "Gentle, shy, stable, sympathetic, and amicable";
                break;

            case 0:
                chinese = "Monkey";
                chineseDesc = "Witty, intelligent, ambitious, and adventurous";
                break;

            case 1:
                chinese = "Rooster";
                chineseDesc = "Observant, hardworking, resourceful, courageous, and talented";
                break;

            case 2:
                chinese = "Dog";
                chineseDesc = "Loyal, honest, amiable, kind, cautious, and prudent";
                break;

            case 3:
                chinese = "Pig";
                chineseDesc = "Diligent, compassionate, generous, easy-going, and gentle";
                break;

            default:
                chinese = "Monkey";
                chineseDesc = "Witty, intelligent, ambitious, and adventurous";
                break;
        }

        switch(Year % 10){

            case 0:
            case 1:
                element = "Metal";
                break;

            case 2:
            case 3:
                element = "Water";
                break;

            case 4:
            case 5:
                element = "Wood";
                break;

            case 6:
            case 7:
                element = "Fire";
                break;

            case 8:
            case 9:
                element = "Earth";
                break;

            default:
                element = "Metal";
        }
    }

    //calculates age to the day
    public void dateDiff(){
        Calendar currentDate = Calendar.getInstance();

        yearsOld = currentDate.get(Calendar.YEAR) - Year;

        if(currentDate.get(Calendar.MONTH) < Month){
            yearsOld = yearsOld - 1;
            monthsOld = (currentDate.get(Calendar.MONTH) + 11) - Month;
            if(currentDate.get(Calendar.DAY_OF_MONTH) == Day){
                ++monthsOld;
            }
        }
        else if((currentDate.get(Calendar.MONTH) == Month) && currentDate.get(Calendar.DAY_OF_MONTH) < Day){
            yearsOld = yearsOld - 1;
            monthsOld = 11;
        }
        else{
            monthsOld = currentDate.get(Calendar.MONTH) - Month;
        }
        if(currentDate.get(Calendar.DAY_OF_MONTH) < Day){
            if(Month == 0 || Month == 2 || Month == 4 || Month == 6 || Month == 7 || Month == 9 || Month == 11){
                daysOld = (31 - Day) + currentDate.get(Calendar.DAY_OF_MONTH);
            }
            else if((Month + 1) == 4 || (Month + 1) == 6 || (Month + 1) == 9 || (Month + 1) == 11){
                daysOld = (30 - Day) + currentDate.get(Calendar.DAY_OF_MONTH);
            }
            else if((Month + 1) == 2 && (currentDate.get(Calendar.YEAR) % 4 == 0) || (currentDate.get(Calendar.YEAR) % 100 == 0) || (currentDate.get(Calendar.YEAR) % 400 ==0)){
                daysOld = (29 - Day) + currentDate.get(Calendar.DAY_OF_MONTH);
            }
            else{
                daysOld = (28 - Day) + currentDate.get(Calendar.DAY_OF_MONTH);
            }
        }
        else{
            daysOld = currentDate.get(Calendar.DAY_OF_MONTH) - Day;
        }
    }

    public void daysOld(){

        if(Month == 1){
            dayOfYear = Day + 31;
        }
        else if(Month == 2){
            dayOfYear = Day + 59;
        }
        else if(Month == 3){
            dayOfYear = Day + 90;
        }
        else if(Month == 4){
            dayOfYear = Day + 120;
        }
        else if(Month == 5){
            dayOfYear = Day + 151;
        }
        else if(Month == 6){
            dayOfYear = Day + 181;
        }
        else if(Month == 7){
            dayOfYear = Day + 212;
        }
        else if(Month == 8){
            dayOfYear = Day + 243;
        }
        else if(Month == 9){
            dayOfYear = Day + 273;
        }
        else if(Month == 10){
            dayOfYear = Day + 304;
        }
        else if(Month == 11){
            dayOfYear = Day + 334;
        }
        else{
            dayOfYear = Day;
        }
        if(Year % 4 == 0 || Year % 100 == 0 || Year % 400 == 0 && Month > 1 && Day != 29){
            ++dayOfYear;
        }
    }

    //display output
    public void output(){

        Calendar currentDate = Calendar.getInstance();
        String outputStr = "";

        outputStr += "Name: " + Name;
        outputStr += "\nCurrent date: " + (currentDate.get(Calendar.MONTH) + 1) + "/" + currentDate.get(Calendar.DAY_OF_MONTH) + "/" + currentDate.get(Calendar.YEAR);
        outputStr += "\nBirth date: " + (Month + 1) + "/" + Day + "/" + Year;
        outputStr += "\nAge: " + yearsOld + " years, " + monthsOld + " months, " + daysOld + " days.";
        outputStr += "\nDay of year born: " + dayOfYear;
        outputStr += "\n\nZodiac sign: " + zodiac;
        outputStr += "\n" + zodiacDesc;
        outputStr += "\n\nChinese zodiac sign: " + chinese;
        outputStr += "\n" + chineseDesc;
        outputStr += "\nElement: " + element;

        textViewDisplayInfo.append(outputStr);
    }
}
