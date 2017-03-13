package com.dpg.pathwars.systems.test;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.dpg.pathwars.components.MovementComponent;
import com.dpg.pathwars.components.TransformComponent;
import com.dpg.pathwars.systems.MovementSystem;
import org.junit.*;

/**
 * Created by darkp on 2/27/2017.
 */

public class MovementSystemTest {

    MovementSystem ms = null;
    Entity entity = null;
    @Before
    public void initialize(){
        ms = new MovementSystem();

        entity = new Entity();

        //Setup components
        TransformComponent tc = new TransformComponent();
        entity.add(new TransformComponent());
        entity.add(new MovementComponent());

    }

    @Test
    public void doesClassExist(){
        assert(MovementSystem.class != null);
    }

    @Test
    public void testProcessEntity(){
        entity.getComponent(MovementComponent.class).velocity.set(Vector2.X);
        ms.processEntity(entity, 1f);

        Vector3 newPos = entity.getComponent(TransformComponent.class).pos;
        assert(newPos.equals(Vector3.X));
    }
}
