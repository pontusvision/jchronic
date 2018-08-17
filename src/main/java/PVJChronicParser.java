import com.mdimension.jchronic.Chronic;
import com.mdimension.jchronic.Options;
import com.mdimension.jchronic.tags.Pointer;
import com.mdimension.jchronic.utils.Span;

import java.util.Scanner;

public class PVJChronicParser
{

  public static void main(String[] args)
  {
    if (args.length < 1)
    {
      System.out.println("Usage:\n\n   java -jar sample-jstl-4.0.2-SNAPSHOT.jar <date string>\n\n"
          + "Note: if <date string> is a dash (-), the addresses will be read from stdin until an EOF");
      System.exit(0);
    }

    StringBuffer sb = new StringBuffer();

    if ("-".equals(args[0]))
    {

      Scanner input = new Scanner(System.in);
      System.out.println("Please enter  a date:");
      System.out.flush();

      while (input.hasNextLine())
      {

        sb.setLength(0);
        String dateStr = input.nextLine();

        System.out.println(dateStr);

        parseDate(dateStr, sb);

        System.out.println(sb.toString());

        System.out.println("\nPlease enter  a date:");
        System.out.flush();


      }

    }
    else
    {
      sb.setLength(0);

      parseDate(args[0], sb);

      System.out.println(sb.toString());

    }

  }

  public static void parseDate(String date, StringBuffer sb)
  {
    Options opts = new Options(Pointer.PointerType.NONE);


    Span span = Chronic.parse(date);
    //    for (int i = 0, ilen = dates.size(); i < ilen; i++)
    //    {
    //      String label = dates.get(i).toString();
    sb.append("\n").append(span.getBeginCalendar().getTime().toString());

    //    }

  }
}
