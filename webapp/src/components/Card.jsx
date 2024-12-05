import Clipboard from './Clipboard';

const Card = ({ origin, href }) => {

  return (
    <div className="w-full max-w-lg block p-6 bg-white border border-gray-200 rounded-lg shadow-lg mt-5 relative dark:bg-gray-800 dark:border-gray-700">
      <a         href={href}
        target="_blank"
        rel="noopener noreferrer" className="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white hover:text-purple-500">
        {href}
      </a>

      <p
        className="font-normal text-gray-700 dark:text-gray-400"
      >
        {origin}
      </p>
      <Clipboard text={href} />
    </div>
  );
};

export default Card;
