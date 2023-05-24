const { defineConfig } = require("cypress");

module.exports = defineConfig({
  projectId: 'nhg6xc',
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
