import { useState, useEffect } from 'preact/hooks';
import Input from './Input.jsx';
import Card from './Card.jsx';
import Toast from './Toast.jsx';
import { API_SERVER } from 'astro:env/client';

export default function Form() {
  const [origin, setOrigin] = useState('');
  const [cards, setCards] = useState([]);
  const [loading, setLoading] = useState(false);
  const [toast, setToast] = useState(null);

  useEffect(() => {
    const savedCards = JSON.parse(localStorage.getItem('cards')) || [];
    setCards(savedCards);
  }, []);

  useEffect(() => {
    if (cards.length > 0) {
      localStorage.setItem('cards', JSON.stringify(cards));
    }
  }, [cards]);

  const showToast = (message) => {
    setToast(message);
  };

  const handleSubmit = async (url) => {
    setLoading(true);

    try {
      const response = await fetch(`${API_SERVER}/api/shorten`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ origin: url }),
      });

      if (!response.ok) {
        
        showToast(
          {
            message: 'An error occurred while shortening the URL. Please try again later.',
            type: 'error'
          }
        );        setLoading(false);
        return;
      }

      const data = await response.json();
      setCards((prevCards) => [
        { href: data.href, origin: url },
        ...prevCards,
      ]);

      setLoading(false);
      setOrigin('');
      showToast(
        {
          message: 'URL shortened successfully!',
          type: 'success'
        }
      );
    } catch (error) {
      setLoading(false);
      showToast(
        {
          message: 'An error occurred while shortening the URL. Please try again later.',
          type: 'error'
        }
      );
    }
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

      {toast && <Toast message={toast.message} type={toast.type} onClose={() => setToast(null)} />}
    </section>
  );
}
