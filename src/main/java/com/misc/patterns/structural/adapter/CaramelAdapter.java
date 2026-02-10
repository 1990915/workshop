package com.misc.patterns.structural.adapter;

import com.misc.patterns.structural.adapter.avaFilters.Caramel;

public class CaramelAdapter extends Caramel implements Filter {
    @Override
    public void apply(Image image) {
        init();
        render(image);
    }
}
