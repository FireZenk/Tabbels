package org.firezenk.tabbels.sample;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.firezenk.tabbels.core.Tabbels;

import butterknife.BindView;
import butterknife.ButterKnife;

import static org.firezenk.tabbels.android.Tabbels.create;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 08/08/16.
 * Project: Tabbels
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView) TextView result;
    @BindView(R.id.hello) TextView hello;
    @BindView(R.id.button) Button button;

    final Tabbels λλ = create(
    ).aλ(
            "onCreate",
            "Overrides onCreate's activity method",
            (self, bundle) -> {
                setContentView(R.layout.main_activity);
                ButterKnife.bind(this);
                result.setText(String.valueOf(self.fλ("pow3", self.fλ("sum2", 2), 2)));
                self.aλ("randomColor", result);
                button.setOnClickListener(v -> self.aλ("click"));
            }
    ).aλ(
            "onStart",
            "Overrides onStart's activity method",
            (self) -> System.out.println("Hello world!")
    ).aλ(
            "toggleHello",
            "Shows or hides the Hello text",
            (self) -> hello.setVisibility(hello.isShown() ? View.GONE : View.VISIBLE)
    ).fλ(
            "sum2", (self, i1) -> (Integer) i1 + 2
    ).fλ(
            "pow3", (self, i1, i2) -> Math.pow((Integer) i1 * (Integer) i2, 3)
    ).inject(
            new MainPresenter().λλ, new ColorHelper().λλ
    ).build();
}
