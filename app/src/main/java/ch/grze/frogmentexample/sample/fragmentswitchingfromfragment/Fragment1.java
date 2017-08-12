package ch.grze.frogmentexample.sample.fragmentswitchingfromfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.frogment.Frogment;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;

public class Fragment1 extends Frogment {
    public Fragment1() {
        super(R.layout.fragment_first_with_button);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.button)
    public void onButtonClick() {
        getFrogmentActivity().switchFrogment(FrogmentData.forClass(Fragment2.class));
    }
}
