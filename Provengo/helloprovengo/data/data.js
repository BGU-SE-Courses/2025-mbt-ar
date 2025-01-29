// @provengo summon selenium 

// Environment Constants
const URL = "http://localhost:8080/";
const ADMIN_URL = "http://localhost:8080/admina";
const ADMIN_CREDS = {
    email: "check@check.check",
    password: "12345678"
};

// XPaths
const xpaths = {
    // Admin Interface
    adminEmail: "//*[@id='email']",
    adminPassword: "//*[@id='passwd']",
    btnAdminLogin: "//form[1]/div[3]",
    adminModules: "//*[@id='subtab-AdminModulesSf']/a[1]",
    adminModulesResult: "//*[@id='content']/div/table/tbody/tr/td/a/strong/span[1]",
    adminModulesSearch: "//*[@id='search-input-group']//input",
    adminModulesSearchBtn: "//*[@id='module-search-button']",
    adminModulesCommentsBtn: "//a[contains(text(),'Product Comments')]",
    adminCommentAllowGuestONBtn: "//*[@id='PRODUCT_COMMENTS_ALLOW_GUESTS_on']",
    adminCommentAllowGuestOFFBtn: "//*[@id='PRODUCT_COMMENTS_ALLOW_GUESTS_off']",
    adminCommentsSubmitBtn: "//*[@id='productcomments_form_submit_btn']",
    
    // Product Interface
    firstProduct: "//section[1]/div[1]/div[1]/article[1]/div[1]/div[1]/a[1]/picture[1]/img[1]",
    btnComment: "//div[5]/button[1]",
    commentTitle: "//*[@id='post-product-comment-form']/div[2]/div[1]/input[1]",
    commentCustomerName: "//*[@id='post-product-comment-form']/div[2]/div[2]/input[1]",
    commentContent: "//*[@id='post-product-comment-form']/textarea[1]",
    sendCommentBtn: "//*[@id='post-product-comment-form']/div/div/button[2]",



   searchBoxXpath : "//*[@id='bo_query']",
   moduleXpath : "//*[@id='content']/div[5]/table/tbody/tr/td[1]/a",
   arrowButtonXpath : "//*[@id='modules-list-container-theme_modules']/div/div/div/div[2]/div[4]/div[2]/button",
   disableToggleXpath : "//*[@id='modules-list-container-theme_modules']/div/div/div/div[2]/div[4]/div[2]/div/li[1]/form/button",
   saveButtonXpath : "//*[@id='module-modal-confirm-productcomments-disable']/div/div/div[3]/a"

};

// System Events
const EVENTS = {
  ADMIN_LOGGED_IN: Event('AdminLoggedIn'),  
  COMMENT_SETTINGS_OPENED: Event('CommentSettingsOpened'),
  GUEST_COMMENTS_ENABLED:Event('GuestCommentsEnabled'),
  GUEST_COMMENTS_DISABLED: Event('GuestCommentsDisabled'),
  SETTINGS_SAVED: Event('SettingsSaved'),
  PRODUCT_PAGE_OPENED: Event('ProductPageOpened'),
  COMMENT_FORM_OPENED: Event('CommentFormOpened'),
  COMMENT_SUBMITTED: Event('CommentSubmitted'),
  COMMENT_BLOCKED: Event('CommentBlocked'),
  ADMIN_SESSION_STARTED: Event('AdminSessionStarted'),
  ADMIN_LOGGED_IN: Event('AdminLoggedIn'),
  COMMENTS_SECTION_OPENED: Event('CommentsSectionOpened'),
  GUEST_COMMENTS_ENABLED: Event('GuestCommentsEnabled')
};
