import { useState, useEffect, useMemo } from 'react';
import AppartementService from '../services/appartementService';
import './css/PageListeAppartements.css';

const PageListeAppartements = () => {
    const [appartements, setAppartements] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [filterPieces, setFilterPieces] = useState(null);
    const [sortOrder, setSortOrder] = useState("none");

    useEffect(() => {
        // On charge tout d'un coup puisqu'on n'a plus le filtre par bâtiment
        AppartementService.getAllAppartements().then(res => setAppartements(res.data));
    }, []);

    const appartementsFiltres = useMemo(() => {
        let res = [...appartements];
        if (searchQuery) {
            res = res.filter(a => a.description?.toLowerCase().includes(searchQuery.toLowerCase()));
        }
        if (filterPieces) {
            res = res.filter(a => a.nbPieces === filterPieces);
        }
        if (sortOrder === "asc") res.sort((a, b) => a.surface - b.surface);
        if (sortOrder === "desc") res.sort((a, b) => b.surface - a.surface);
        return res;
    }, [appartements, searchQuery, filterPieces, sortOrder]);

    return (
        <div className="lux-page">
            <header className="lux-header-v2">
                <span className="subtitle">Collection Privée</span>
                <h1>Appartements <span className="gold">Azurimmo</span></h1>
            </header>

            {/* BARRE UNIQUE HORIZONTALE */}
            <div className="modern-filter-dock">
                <input
                    type="text"
                    placeholder="Rechercher..."
                    className="dock-input"
                    onChange={(e) => setSearchQuery(e.target.value)}
                />

                <div className="dock-separator"></div>

                <div className="dock-segments">
                    <button className={filterPieces === null ? 'active' : ''} onClick={() => setFilterPieces(null)}>Tout</button>
                    {[1, 2, 3, 4].map(n => (
                        <button
                            key={n}
                            className={filterPieces === n ? 'active' : ''}
                            onClick={() => setFilterPieces(n)}
                        >
                            {n}P
                        </button>
                    ))}
                </div>

                <div className="dock-separator"></div>

                <div className="dock-segments">
                    <button className={sortOrder === 'asc' ? 'active' : ''} onClick={() => setSortOrder('asc')}>m² ↑</button>
                    <button className={sortOrder === 'desc' ? 'active' : ''} onClick={() => setSortOrder('desc')}>m² ↓</button>
                </div>
            </div>

            <div className="appart-grid">
                {appartementsFiltres.map((app, index) => (
                    <div className="appart-card" key={index}>
                        <div className="card-image">
                            <span className="tag-pieces">{app.nbPieces} Pièces</span>
                        </div>
                        <div className="card-body">
                            <div className="card-header">
                                <span className="unit-ref"># {app.numero}</span>
                                <span className="unit-surface">{app.surface} m²</span>
                            </div>
                            <h3>{app.description}</h3>
                            <p className="card-location">Prestige • France</p>
                            <button className="btn-detail">Détails</button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default PageListeAppartements;