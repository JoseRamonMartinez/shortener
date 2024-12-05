import { useState, useEffect } from 'preact/hooks';
import Input from './Input.jsx';
import Card from './Card.jsx';


export default function Form() {
  const [origin, setOrigin] = useState('');
  const [cards, setCards] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const savedCards = JSON.parse(localStorage.getItem('cards')) || [];
    setCards(savedCards);
  }, []);

  useEffect(() => {
    if (cards.length > 0) {
      localStorage.setItem('cards', JSON.stringify(cards));
    }
  }, [cards]);


  const handleSubmit = async (url) => {
    setLoading(true);

    const response = await fetch('/api/shorten', {
      method: 'POST',
      headers: { 
        'Content-Type': 'application/json',
       },
      body: JSON.stringify({ origin: url }),
    });

    if (!response.ok) {
      throw new Error('Failed to shorten URL');
    }

    const data = await response.json();
    setCards((prevCards) => [
      { href: data.href, origin: url },
      ...prevCards,
    ]);

    setLoading(false);
    setOrigin('');
  };

  return (
    <section class="w-full max-w-lg rounded-lg p-6 mb-12">
      <Input
            origin={origin}
            setOrigin={setOrigin}
            onSubmit={handleSubmit}
            loading={loading}
          />

      {cards.length > 0 && (
        <div>
          {cards.map((card, index) => (
            <Card key={index} origin={card.origin} href={card.href} />
          ))}
        </div>
      )}
    </section>
  );
}
