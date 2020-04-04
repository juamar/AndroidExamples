package solutions.lhdev.fragmentexample.builders;

import android.content.Context;
import android.support.constraint.ConstraintLayout;

/**
 * Created by JuanIgnacio on 11/03/2018.
 */

public class ParamBuilder
{
    public static ConstraintLayout.LayoutParams buildParams(Context context) {
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        final float scale = context.getResources().getDisplayMetrics().density;
        params.topMargin = (int) (16 * scale + 0.5f);

        return params;
    }
}
