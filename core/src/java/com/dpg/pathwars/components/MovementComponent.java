package com.dpg.pathwars.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by darkp on 2/27/2017.
 */
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class MovementComponent implements Component {
    public final Vector2 velocity = new Vector2();
    public final Vector2 accel = new Vector2();
}