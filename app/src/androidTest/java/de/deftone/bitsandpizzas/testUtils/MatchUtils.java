package de.deftone.bitsandpizzas.testUtils;

import android.support.annotation.NonNull;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static android.support.test.espresso.core.internal.deps.guava.base.Preconditions.checkNotNull;

/**
 * Created by deftone on 26.12.17.
 */

public class MatchUtils {
    public static Matcher<View> eigenerMatcher(final int position,
                                                @NonNull final Matcher<View> itemMatcher) {
        checkNotNull(itemMatcher);
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has item at position " + position + ": ");
                itemMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) {
                if (recyclerView == null) {
                    return false;
                }

                RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(position);

                if (viewHolder == null) {
                    return false;
                }

                return itemMatcher.matches(viewHolder.itemView);
            }
        };
    }
}
