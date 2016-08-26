[![Build Status](https://travis-ci.org/android-group/android-studio-pages.svg?branch=master)](https://travis-ci.org/android-group/android-studio-pages)
# android-studio-pages
API
:trollface:

/api/v1/categories - all categories

/api/v1/categoryTags?id=N - tags in the given category

/api/v1/page?id=N - full page information

/api/v1/pages?category=N - pages in the given category (list only)

/api/v1/pages?tags=A,B - pages containing given tags (OR criteria)

/api/v1/pages?category=N&tags=A,B - pages in the given category containing given tags (OR criteria)
