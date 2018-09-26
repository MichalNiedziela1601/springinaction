package com.spitter.dao;

import com.spitter.model.Spitter;

public interface SpitterDao {

    void addSpitter(Spitter spitter);

    void updateSpitter(Spitter spitter);

    Spitter getSPitterByID(long id);
}
