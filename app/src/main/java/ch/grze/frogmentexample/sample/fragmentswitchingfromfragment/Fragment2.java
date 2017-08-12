package ch.grze.frogmentexample.sample.fragmentswitchingfromfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.frogment.Frogment;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;

public class Fragment2 extends Frogment {
    public Fragment2() {
        super(R.layout.fragment_second_with_button);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.button)
    public void onButtonClick() {
        getFrogmentActivity().switchFrogment(FrogmentData.forClass(Fragment1.class));
    }
}
