package org.firezenk.tabbels;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.firezenk.tabbles.Tabbels;

import static org.firezenk.tabbles.Tabbels.create;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 08/08/16.
 * Project: Tabbels
 */
public class MainActivity extends AppCompatActivity {

    final Tabbels λλ = create(
    ).λ(
            "onCreate", (self, bundle) -> {
                setContentView(R.layout.main_activity);

                final TextView tv = (TextView) findViewById(R.id.textView);
                tv.setText(String.valueOf(self.λ("pow3", self.λ("sum2", 2), 2)));

                return null;
            }
    ).λ(
            "onStart", (self) -> {
                System.out.println("Hello world!");
                return null;
            }
    ).λ(
            "sum2", (self, i1) -> (Integer) i1 + 2
    ).λ(
            "pow3", (self, i1, i2) -> Math.pow((Integer) i1 * (Integer) i2, 3)
    ).build();
}
