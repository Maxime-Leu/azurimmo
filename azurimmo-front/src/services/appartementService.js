import axios from 'axios';

// On définit les deux URLs de base
const API_URL_APPART = "http://localhost:9008/api/appartements";
const API_URL_BAT = "http://localhost:9008/api/batiments";

class AppartementService {

    // --- PARTIE APPARTEMENTS ---
    getAppartementsParBatiment(batimentId) {
        return axios.get(`${API_URL_APPART}/batiment/${batimentId}`);
    }

    findByVille(ville) {
        return axios.get(`${API_URL_APPART}/ville/${ville}`);
    }

    findAppartementsBySurfaceGreaterThan(surface) {
        return axios.get(`${API_URL_APPART}/surfaceGreaterThan/${surface}`);
    }

    createAppartement(appartement) {
        return axios.post(`${API_URL_APPART}/`, appartement);
    }
    getAllAppartements() {
        return axios.get("http://localhost:9008/api/appartements");
    }

    // --- PARTIE BÂTIMENTS (La nouveauté) ---
    getBatiments() {
        return axios.get(API_URL_BAT);
    }
}

export default new AppartementService();