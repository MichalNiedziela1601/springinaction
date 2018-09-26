package com.springidol;

public class Instrumentalist implements Performer {

    private Instrument instrument;

    public Instrumentalist(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public void perform() throws PerformerException {

        this.instrument.play();
    }
}
