package searchtutorial.duckduckgo.steps;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import searchtutorial.duckduckgo.pageobjects.DuckDuckGoSearchPage;
import searchtutorial.duckduckgo.pageobjects.DuckDuckGoSearchResult;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DuckDuckGoSearcher {

    DuckDuckGoSearchPage searchPage;
    DuckDuckGoSearchResult searchResult;

    @Step
    public void is_on_the_duckduckgo_homepage() {
        searchPage.open();
    }

    @Step
    public void searches_by_keyword_for(String keyword) {
        searchPage.enterSearchTerms(keyword);
        searchPage.submitSearch();
    }

    @Step
    public void should_only_see_only_results_containing(String expectedTerms) {
        List<String> results = searchResult.getDisplayedResult();
        assertThat(results, everyItem(containsString(expectedTerms)));
    }
}
