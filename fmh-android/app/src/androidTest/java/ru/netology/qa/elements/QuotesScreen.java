package ru.netology.qa.elements;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.netology.qa.util.Util.withIndex;

public class QuotesScreen {
    public ViewInteraction quotes = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction quotesScreen = onView(withId(R.id.our_mission_title_text_view));
    public ViewInteraction title = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    public ViewInteraction description = onView(withIndex(withId(R.id.our_mission_item_description_text_view),0));
    public ViewInteraction titleRollUp = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    public ViewInteraction descriptionRollUp = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
}