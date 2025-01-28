/* @provengo summon selenium */
/* @provengo summon constraints */

// Test case 1 - Guest submits
bthread('Guest submits comment', function() {
  const guestSession = new SeleniumSession('guest');
  guestSession.start(URL);


  openFirstProduct(guestSession);
  submitProductReview(guestSession);
});

// Test Case 2: Disable Guest Comments
bthread('Admin disables guest comments', function() {
  const adminSession = new SeleniumSession('admin');
  adminSession.start(ADMIN_URL);

  // Prevent turning OFF before it was turned ON
  // Constraints
  //   .block(Event('Start(toggleGuestCommentsOFF)'))
  //   .until(Event('End(toggleGuestCommentsON)'));

  adminLogin(adminSession);  
  navigateToCommentsSection(adminSession);
  toggleOFFGuestComments(adminSession);
});

/** Guest tries to add a review after turned off - Test should fail */
bthread('Verify comment after blocking rev', function() {
  const guestSession = new SeleniumSession('guest');
  guestSession.start(URL);
  commentWhenBlockShouldFail(guestSession);
});
