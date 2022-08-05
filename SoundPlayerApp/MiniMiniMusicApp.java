package SoundPlayerApp;
import javax.sound.midi.*;

public class MiniMiniMusicApp {
    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp(); 
        if (args.length < 2) {
            System.out.println("Don't forget the instrument and note args");
        } else {
            int instrument = Integer.parseInt(args[0]); 
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note); 
        }
    }

    public void play(int instrument, int note) {
        try {
            // get a sequencer and open it (doesn't come open)
            Sequencer player = MidiSystem.getSequencer(); 
            player.open();

            // get a sequence 
            Sequence seq = new Sequence(Sequence.PPQ, 4); 

            // ask sequencer for a Track
            Track track = seq.createTrack();
            
            MidiEvent event = null;
            
            // put midievents into the track
            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1); 
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage(); 
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn); 

            ShortMessage b = new ShortMessage(); 
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 16); 
            track.add(noteOff);

            // give the sequence to the sequencer 
            // start the sequencer 
            player.setSequence(seq); 
            player.start(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}