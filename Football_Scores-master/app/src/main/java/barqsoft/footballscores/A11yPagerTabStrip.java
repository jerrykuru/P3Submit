package barqsoft.footballscores;

import android.content.Context;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;

/**
 * Created by binu on 2/13/16.
 */
public class A11yPagerTabStrip extends PagerTabStrip {
    public static final String LOG_TAG = "A11yPagerTabStrip";
    public A11yPagerTabStrip(Context context) {
        super(context);
    }

    public A11yPagerTabStrip(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        Log.wtf(LOG_TAG, "onRequestSendAccessibilityEvent: " + event.toString());

        final String textViewTitle = ((TextView) child).getText().toString();
        final ViewPager viewPager = (ViewPager) this.getParent();
        final int itemIndex = viewPager.getCurrentItem();

        String title = viewPager.getAdapter().getPageTitle(itemIndex).toString();

        if (textViewTitle.equalsIgnoreCase(title)) {
            child.setContentDescription("Tab " + textViewTitle + "selected.");
        } else {
            child.setContentDescription("Tab " + textViewTitle + "not selected.");
        }

        return super.onRequestSendAccessibilityEvent(child, event);
    }

}
