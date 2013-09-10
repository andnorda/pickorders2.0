git push heroku master --force
heroku pg:reset HEROKU_POSTGRESQL_GOLD_URL --confirm pickorders
heroku restart
