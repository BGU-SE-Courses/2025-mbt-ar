// @provengo summon ctrl

/**
 * List of events "of interest" that we want test suites to cover.
 */
const GOALS_DOMAIN_SPECIFIC = [
    // Ensuring the admin can log in and navigate to comments is critical.
    Ctrl.markEvent("End(AdminLogin)"),
    Ctrl.markEvent("End(AdminNavigateToCommentsSection)"),
    // Ensuring comment functionality works as expected.
    Ctrl.markEvent("End(submitProductReview)"),
    // Ensuring toggles for comments work both ways.
    Ctrl.markEvent("End(toggleGuestComments)"),
    Ctrl.markEvent("End(toggleGuestCommentsOFF)")
];

const GOALS_TWO_WAYS = [
    // Check that comments can be toggled on and off.
    [Ctrl.markEvent("End(toggleGuestComments)"), Ctrl.markEvent("End(toggleGuestCommentsOFF)")]
];

const GOALS = GOALS_DOMAIN_SPECIFIC
// const GOALS =GOALS_TWO_WAYS

const makeGoalsTwoWay = function() {
    return GOALS_TWO_WAYS;
};

const makeGoalsDomainSpecific = function() {
    return GOALS_DOMAIN_SPECIFIC;
};


/**
 * Ranks test suites by how many events from the GOALS array were met.
 * The more goals are met, the higher the score.
 * 
 * It make no difference if a goal was met more then once.
 *
 * @param {Event[][]} ensemble The test suite to be ranked.
 * @returns Number of events from GOALS that have been met.
*/
function rankByMetGoals(ensemble) {
    let metGoalsCount = 0;

    ensemble.forEach(test => {
        test.forEach(event => {
            if (GOALS.some(goal => goal.eventName === event.eventName)) {
                metGoalsCount++;
            }
        });
    });

    return metGoalsCount; // Return the count of met goals.
}


function rankingFunction(ensemble) {
    const metGoalsCount = rankByMetGoals(ensemble);
    const metGoalsPercent = metGoalsCount / GOALS.length;

    return metGoalsPercent * 100; // Convert to percentage
}


