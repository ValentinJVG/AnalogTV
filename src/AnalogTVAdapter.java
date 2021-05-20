
public class AnalogTVAdapter {

    public static void main(String[] args) {


        AllFormatMediaBox mediaBox;

        AllFormatMediaBox player = new AndroidMegaSuperDuperMediaBox(new SamsungVCR());
        player.play("Terminator");

        mediaBox = new AndroidMegaSuperDuperMediaBox(new PhilipsDVDPlayer());
        mediaBox.play("Terminator II. Judgment day.");

        mediaBox = new AndroidMegaSuperDuperMediaBox(new PhilipsBlueRayPlayer());
        mediaBox.play("Die Hard");

        mediaBox = new AndroidMegaSuperDuperMediaBox(new Viasat());
        mediaBox.play("Discovery channel");
    }
}

interface AllFormatMediaBox {
    void play(String nameOfTheContent);
}

interface VCR {
    void play(String cassetteName);

}

interface DVDPlayer {
    void play(String dvdName);
}

interface BlueRayPlayer {
    void play(String blueRayName);
}

interface SatTV {
    void play(String channel);
}

class SamsungVCR implements VCR {

    @Override
    public void play(String movie) {
        System.out.println(" Playing " + movie + " from VCR.");
    }
}

class PhilipsDVDPlayer implements DVDPlayer {

    @Override
    public void play(String dvdName) {
        System.out.println(" Playing " + dvdName + " from DVD player.");
    }
}

class PhilipsBlueRayPlayer implements BlueRayPlayer {

    @Override
    public void play(String blueRayName) {
        System.out.println(" Playing " + blueRayName + " from BlueRay.");
    }
}

class Viasat implements SatTV {

    @Override
    public void play(String channel) {
        System.out.println(" Playing " + channel + " from Viasat.");
    }
}

class AndroidMegaSuperDuperMediaBox implements AllFormatMediaBox {
    private VCR vcr;
    private DVDPlayer dvdPlayer;
    private BlueRayPlayer blueRayPlayer;
    private SatTV satTV;

    public AndroidMegaSuperDuperMediaBox(VCR vcr) {
        this.vcr = vcr;
    }

    public AndroidMegaSuperDuperMediaBox(DVDPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public AndroidMegaSuperDuperMediaBox(BlueRayPlayer blueRayPlayer) {
        this.blueRayPlayer = blueRayPlayer;
    }

    public AndroidMegaSuperDuperMediaBox(SatTV satTV) {
        this.satTV = satTV;
    }


    @Override
    public void play(String nameOfTheContent) {
        if (vcr != null) {
            vcr.play(nameOfTheContent);
        } else if (dvdPlayer != null) {
            dvdPlayer.play(nameOfTheContent);
        } else if (blueRayPlayer != null) {
            blueRayPlayer.play(nameOfTheContent);
        } else if (satTV != null) {
            satTV.play(nameOfTheContent);
        } else {
            System.out.println("Not supported signal, please contact technical support for more information.");
        }

    }
}




