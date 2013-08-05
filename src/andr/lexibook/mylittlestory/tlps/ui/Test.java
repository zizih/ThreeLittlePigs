package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.tlps.control.PageFactory;
import android.os.Bundle;

/**
 * Created by rain on 8/5/13.
 */
public class Test extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(PageFactory.getInstance(this).getPage(2).getLayout());
    }
}
