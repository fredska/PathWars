package com.dpg.pathwars.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.dpg.pathwars.components.MovementComponent;
import com.dpg.pathwars.components.TransformComponent;

/**
 * Created by darkp on 2/27/2017.
 */
public class MovementSystem extends IteratingSystem{

    private ComponentMapper<TransformComponent> tm;
    private ComponentMapper<MovementComponent> mm;

    public MovementSystem() {
        super(Family.all(TransformComponent.class, MovementComponent.class).get());

        tm = ComponentMapper.getFor(TransformComponent.class);
        mm = ComponentMapper.getFor(MovementComponent.class);
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {
        TransformComponent tc = tm.get(entity);
        MovementComponent mc = mm.get(entity);

        mc.velocity.add(mc.accel.scl(deltaTime));
        tc.pos.add(mc.velocity.x * deltaTime, mc.velocity.y * deltaTime, 0);
    }
}
