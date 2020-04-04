package solutions.lhdev.fragmentexample.builders;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.view.View;

/**
 * Created by JuanIgnacio on 11/03/2018.
 */

public class ConstraintSetBuilder
{
    public static ConstraintSet buildConstraintSet(Context context,
                                                   ConstraintLayout constraintLayout,
                                                   ConstraintSet constraintSet,
                                                   View view)
    {
        constraintSet.clone(constraintLayout);

        final float scale = context.getResources().getDisplayMetrics().density;

        constraintSet.connect(view.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        constraintSet.connect(view.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);

        return constraintSet;
    }
}
