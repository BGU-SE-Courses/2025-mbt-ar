// @provengo summon selenium 
// @provengo summon ctrl

// Admin actions
function adminLogin(session) {
  // Login start marker
  sync({request: Event('Start(AdminLogin)')});
  
  // login steps
  with(session) {
    writeText(xpaths.adminEmail, ADMIN_CREDS.email);
    writeText(xpaths.adminPassword, ADMIN_CREDS.password);
    click(xpaths.btnAdminLogin);
  }
  
  // Login completion 
  sync({
    request: Event('End(AdminLogin)'),
    request: Ctrl.markEvent('End(AdminLogin)')
  });
}

function navigateToCommentsSection(session) {
  sync({
    request: Event('Start(AdminNavigateToCommentsSection)'),
    waitFor: Event('End(AdminLogin)'),
  });

  with (session) {

    // Call pressSearch directly
    writeText("//*[@id=\"bo_query\"]","comment")
    click("//*[@id=\"subtab-AdminParentModulesSf\"]");
    click("//li[9]/ul[1]/li[1]/a[1]");
    writeText("//div[1]/div[2]/input[1]", "comment");
    click("//div[2]/button[1]/i[1]");
    click("//div[4]/div[2]/a[1]");

  }

  sync({ request: Event('End(AdminNavigateToCommentsSection)'),
    request: Ctrl.markEvent('End(AdminNavigateToCommentsSection)')

  });
}




function toggleOFFGuestComments(session) {
  sync({request: Event('Start(toggleGuestCommentsOFF)'),
    waitFor: Event('End(AdminNavigateToCommentsSection)'),
    waitFor: Event('End(AdminLogin)')
  });
      with(session){
        click("//*[@id='PRODUCT_COMMENTS_ALLOW_GUESTS_off']");
        click("//*[@id='productcomments_form_submit_btn']");
      }

  
  sync({request:Event('End(toggleGuestCommentsOFF)'),
    request: Ctrl.markEvent('End(toggleGuestCommentsOFF)')

  });
}


function toggleGuestCommentsON(session) {
  sync({request: Event('Start(toggleGuestComments)'),
    waitFor: Event('End(AdminNavigateToCommentsSection)'),
    waitFor: Event('End(AdminLogin)'),
  });

  with(session){
    click("//*[@id='PRODUCT_COMMENTS_ALLOW_GUESTS_on']");
    click("//*[@id='productcomments_form_submit_btn']");
  }                         
  
  sync({request:Event('End(toggleGuestComments)'),
    request: Ctrl.markEvent('End(toggleGuestComments)')

  });
}

// Product actions
function openFirstProduct(session) {
  sync({request: Event('Start(openFirstProduct)')});
      session.click(xpaths.firstProduct);

      
      
  sync({request:Event('End(openFirstProduct)'),
    request: Ctrl.markEvent('End(openFirstProduct)')

  });
}

// Product actions
function commentWhenBlockShouldFail(session) {
  sync({request: Event('Start(openFirstProduct)'),
    waitFor: Event('End(toggleGuestCommentsOFF)')
  });
  openFirstProduct(session);
  submitProductReview(session);

  sync({request:Event('End(openFirstProduct)'),
    request: Ctrl.markEvent('End(openFirstProduct)')

  });
}



function scrollDown(session) {
  window.scrollTo(0, document.body.scrollHeight);
  pvg.success('yes');
}

function submitProductReview(session) {
  sync({request: Event('Start(submitProductReview)'), 
    waitFor: Event('End(openFirstProduct)'),
    // waitFor: Event('End(toggleGuestCommentsON)')   // cant leave a review without the admin turn on the review.  
  });

  with(session){
    runCode(scrollDown);
    click(xpaths.btnComment);
    
      writeText(xpaths.commentTitle, "Title");
      writeText(xpaths.commentCustomerName, "GuestName");
      writeText(xpaths.commentContent, "Almost Good Review");
      click(xpaths.sendCommentBtn);
  }

  sync({
      request:Event('End(submitProductReview)'),
      request: Ctrl.markEvent('End(submitProductReview)')

  });
}
