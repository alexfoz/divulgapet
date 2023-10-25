const admin = require("firebase-admin");
const serviceAccount = require("./clinicapet-54038-firebase-adminsdk-dbxu1-4749ddedac.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://clinicapet-54038-default-rtdb.firebaseio.com/"
});

const db = admin.database();
module.exports = db;