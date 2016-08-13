package org.firezenk.tabbels.sample;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.firezenk.tabbels.android.Tabbels;

import static org.firezenk.tabbels.android.Tabbels.create;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 08/08/16.
 * Project: Tabbels
 */
public class MainActivity extends AppCompatActivity {

    final Tabbels λλ = (Tabbels) create(
    ).aλ(
            "onCreate", (self, bundle) -> {
                setContentView(R.layout.main_activity);

                final TextView tv = (TextView) findViewById(R.id.textView);
                if (tv != null)
                    tv.setText(String.valueOf(self.fλ("pow3", self.fλ("sum2", 2), 2)));
            }
    ).aλ(
            "onStart", (self) -> System.out.println("Hello world!")
    ).fλ(
            "sum2", (self, i1) -> (Integer) i1 + 2
    ).fλ(
            "pow3", (self, i1, i2) -> Math.pow((Integer) i1 * (Integer) i2, 3)
    ).build();
}
