public class Show
{
    private String name;
    private String airTime;

    public Show(String name, int hour, int minute)
    {
        if(hour < 0 || hour > 24)
        {
            System.out.println("Warning: invalid hour: " + hour);
        }
        if(minute < 0 || minute > 59)
        {
            System.out.println("Warning: invalid minute: " + minute);
        }

        this.name = name;
        // TODO: sting format
        //airTime = String.format();
    }
}

public class TvNetwork
{

}
