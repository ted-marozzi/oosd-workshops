class Show {
    private String name;
    private String airTime;

    public Show(String name, int hour, int minute) {
        if (hour < 0 || hour > 24) {
            System.out.println("warning: invalid hour: " + hour);
        }
        if (minute < 0 || minute > 59) {
            System.out.println("warning: invalid minute: " + minute);
        }

        this.name = name;
        airTime = String.format("%02d:%02d", hour, minute);
    }

    public String toString() {
        return String.format("%s airing at %s", name, airTime);
    }
}

class Channel
{
    private final String name;
    private Show[] shows = new Show[5];
    private int numShows = 0;

    public Channel(String name)
    {
        this.name = name;


    }

    public void createShow(String name, int hour, int minute)
    {
        Show show = new Show(name, hour, minute);
        System.out.println(show);


        shows[numShows] = show;
        numShows++;
    }

    public String toString()
    {
        String channelString = "";
        String showString = "";

        for(int i=0; i < this.numShows; i++)
        {
            showString = shows[i].toString();
            channelString = channelString + showString;
        }
        return channelString;

    }

}

public class TvNetwork
{
    public static void main(String[] args) {

        Channel channel7 = new Channel("Channel 7");
        channel7.createShow("Channel 7 News", 7, 30);
        channel7.createShow("Channel 7 Sport", 8, 30);
        channel7.toString();
    }
}