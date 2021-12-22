package Solution12_4_4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


    // write class which print time as HH:MM:SS
    // every second here



public class ConsoleClock extends Thread{
    @Override
    public void run() {
        while(!isInterrupted()) {
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");   //1.
            Calendar calendar = Calendar.getInstance(); //2
            calendar.getTime(); //3
            String time = timeFormat.format(calendar.getTimeInMillis());    //4
            System.out.println(time);
            try{
                Thread.sleep(1000); //5
            } catch(InterruptedException exception) {
                break;
            }
        }
        System.out.println("The clock was stopped");
    }
}

/*
1.Создает SimpleDateFormat с использованием заданного шаблона и символов формата даты
по умолчанию для языкового стандарта FORMAT по умолчанию.
2. Получает календарь с использованием часового пояса и языкового стандарта по умолчанию.
Возвращаемый календарь основан на текущем времени в часовом поясе по умолчанию с языковым
стандартом FORMAT по умолчанию.
3. Возвращает объект Date, представляющий значение времени этого календаря
4. format() - Форматирует объект для создания строки.
5. Заставляет текущий выполняющийся поток спать (временно прекращать выполнение) на указанное
количество миллисекунд, в зависимости от точности и точности системных таймеров и планировщиков.
 */