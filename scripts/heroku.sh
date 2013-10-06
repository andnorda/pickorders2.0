git push heroku master --force
heroku pg:reset HEROKU_POSTGRESQL_MAROON_URL --confirm pickorders
heroku restart
