package org.firezenk.tabbels.sample;

import android.graphics.Color;
import android.widget.TextView;

import org.firezenk.tabbels.core.Tabbels;

import java.util.Random;

import static org.firezenk.tabbels.core.Tabbels.create;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 21/08/16.
 * Project: Tabbels
 */
public class ColorHelper {

    final Tabbels λλ = create(
    ).aλ(
            "randomColor", (self, textView) -> {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                ((TextView) textView).setTextColor(color);
            }
    ).build();
}
